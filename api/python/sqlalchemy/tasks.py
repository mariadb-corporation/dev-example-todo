import sys
import json
import os
import flask
from flask import request
from flask import Blueprint
from dotenv import load_dotenv
import decimal, datetime
import sqlalchemy
from sqlalchemy.ext.declarative import declarative_base

load_dotenv()

tasks = Blueprint('tasks', __name__)

# Define the MariaDB engine using MariaDB Connector/Python
engine = sqlalchemy.create_engine(
    "mariadb+mariadbconnector://{0}:{1}@{2}:{3}/{4}".format(os.getenv("DB_USER"),os.getenv("DB_PASS"),os.getenv("DB_HOST"),os.getenv("DB_PORT"),os.getenv("DB_NAME")),
    echo=True)

Base = declarative_base()

class Task(Base):
    __tablename__ = 'tasks'
    id = sqlalchemy.Column(sqlalchemy.Integer, primary_key=True)
    description = sqlalchemy.Column(sqlalchemy.String(length=200))
    completed = sqlalchemy.Column(sqlalchemy.Boolean, default=False)

def alchemyencoder(obj):
    """JSON encoder function for SQLAlchemy special classes."""
    if isinstance(obj, datetime.date):
        return obj.isoformat()
    elif isinstance(obj, decimal.Decimal):
        return float(obj)

@tasks.route('/api/tasks', methods=['GET','POST','PUT','DELETE'])
def index():
   # Create a SQLAlchemy session
   Session = sqlalchemy.orm.sessionmaker()
   Session.configure(bind=engine)
   session = Session() 

   json_data = []

   if request.method == 'GET':
      tasks = session.query(Task).all()
      for task in tasks:
        temp_dict = task.__dict__
        temp_dict.pop('_sa_instance_state',None)
        json_data.append(temp_dict)
   
   if request.method == 'POST':
       task = Task(description=request.json['description'])
       session.add(task)
       session.commit()
       json_data = { 'success': True }

   if request.method == 'PUT':
       id = request.json['id']
       description = request.json['description']
       completed = request.json['completed']
       task = session.query(Task).get(id)
       task.description = description
       task.completed = completed
       session.commit()
       json_data = { 'success': True }

   if request.method == 'DELETE':
       id = request.args.get('id')
       session.query(Task).filter(Task.id == id).delete()
       session.commit()
       json_data = { 'success': True }

   return json.dumps(json_data, default=alchemyencoder), 200, {'ContentType':'application/json'} 