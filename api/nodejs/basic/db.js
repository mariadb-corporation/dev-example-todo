// Use the MariaDB Node.js Connector
var mariadb = require('mariadb');

require('dotenv').config();

// 1.) Access the Node File System package
//const fs = require("fs");

// 2.) Retrieve the Certificate Authority chain file (wherever you placed it - notice it's just in the Node project root here)
//const serverCert = [fs.readFileSync("skysql_chain.pem", "utf8")];

// Create a connection pool
var pool = 
  mariadb.createPool({
    host: process.env.DB_HOST, 
    user: process.env.DB_USER, 
    password: process.env.DB_PASS,
    port: process.env.DB_PORT,
    database: process.env.DB_NAME
    // 3.) Add an "ssl" property to the connection pool configuration, using the serverCert const defined above
    /*
    ssl: {
      ca: serverCert
    }*/
  });

// Expose the Pool object within this module
module.exports = Object.freeze({
  pool: pool
});
