const express = require('express');
const app = express();
const port = 8080;
const bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

const db = require("./db.js");

db.sequelize.sync();

// simple route
app.get("/", (req, res) => {
  res.json({ message: "Welcome to a MariaDB application." });
});

require("./routes/task.routes")(app);

// console.log that your server is up and running
app.listen(port, () => console.log(`Listening on port ${port}`));

