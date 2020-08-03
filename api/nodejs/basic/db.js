// Use the MariaDB Node.js Connector
var mariadb = require('mariadb');
require('dotenv').config();

// Retrieve the Certificate Authority chain file (using the File System package)
const fs = require("fs");
const serverCert = [fs.readFileSync("skysql_chain.pem", "utf8")];

// Create a connection pool
var pool = 
  mariadb.createPool({
    host: process.env.DB_HOST, 
    user: process.env.DB_USER, 
    password: process.env.DB_PASS,
    port: process.env.DB_PORT,
    database: process.env.DB_NAME,
    multipleStatements: true,
    connectionLimit: 5,
    ssl: {
      ca: serverCert
    }
  });

// Expose a method to establish connection with MariaDB SkySQL
module.exports={
  getConnection: function(){
    return new Promise(function(resolve,reject){
      pool.getConnection().then(function(connection){
        resolve(connection);
      }).catch(function(error){
        reject(error);
      });
    });
  }
} 