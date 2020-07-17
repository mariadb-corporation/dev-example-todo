import sys
import json
import mariadb
import os
import flask
from flask import request
from flask import Blueprint
from dotenv import load_dotenv

load_dotenv()

tasks = Blueprint('tasks', __name__)

config = {
    'host': os.getenv("DB_HOST"),
    'port': int(os.getenv("DB_PORT")),
    'user': os.getenv("DB_USER"),
    'password': os.getenv("DB_PASS"),
    'database': os.getenv("DB_NAME"),
    'ssl': 'True'
}

@tasks.route('/api/tasks', methods=['GET','POST','PUT','DELETE'])
def index():
   conn = mariadb.connect(**config)
   cur = conn.cursor()

   json_data = []

   if request.method == 'GET':
    cur.execute("select * from tasks order by id desc")
    row_headers=[x[0] for x in cur.description] 
    rv = cur.fetchall()
    for result in rv:
        json_data.append(dict(zip(row_headers,result)))
   
   if request.method == 'POST':
       description = request.json['description']
       cur.execute("insert into tasks (description) values (?)",[description])
       json_data = { 'success': True }

   if request.method == 'PUT':
       id = request.json['id']
       description = request.json['description']
       completed = request.json['completed']
       cur.execute("update tasks set description = ?, completed = ? where id = ?", [description,completed,id])
       json_data = { 'success': True }

   if request.method == 'DELETE':
       id = request.args.get('id')
       cur.execute("delete from tasks where id = ?",[id])
       json_data = { 'success': True }

   return json.dumps(json_data), 200, {'ContentType':'application/json'} 