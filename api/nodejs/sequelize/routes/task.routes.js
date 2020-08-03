module.exports = app => {
    const tasks = require("../controllers/task.controller.js");

    var router = require("express").Router();

    // Create a new Task
    router.post("/", tasks.create);

    // Retrieve all Tasks
    router.get("/", tasks.findAll);


    // Update a Task with id
    router.put("/", tasks.update);

    // Delete a Task with id
    router.delete("/", tasks.delete);

    app.use('/api/tasks', router);
};