require('dotenv').config();

// 1.) Access the Node File System package
//const fs = require("fs");

// 2.) Retrieve the Certificate Authority chain file (wherever you placed it - notice it's just in the Node project root here)
//const cert = [fs.readFileSync("skysql_chain.pem", "utf8")];

const Sequelize = require("sequelize");
const sequelize = new Sequelize(process.env.DB_NAME, process.env.DB_USER, process.env.DB_PASS, {
  host: process.env.DB_HOST,
  port: process.env.DB_PORT,
  dialect: 'mariadb',
  // 3.) Add an "ssl" property to the dialectOptions configuration, using the serverCert const defined above
  /*dialectOptions: {
    ssl: {
      ca: cert
    }
  },*/
  define: {
    timestamps: false
  }
});

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

db.tasks = require("./models/task.model.js")(sequelize, Sequelize);

module.exports = db;