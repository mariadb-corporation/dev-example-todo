module.exports = (sequelize, Sequelize) => {
    const Task = sequelize.define("task", {
      id: {
        type: Sequelize.INTEGER,
        primaryKey: true
      },
      description: {
        type: Sequelize.STRING
      },
      completed: {
        type: Sequelize.BOOLEAN
      }
    });
    return Task;
  };