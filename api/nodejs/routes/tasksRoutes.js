"use strict";

let express = require("express"),
    router = express.Router(),
    pool = require('../db');

// GET 
router.get("/", async (req, res, next) => {
    let conn;
    try {
        conn = await pool.getConnection();
        var query = "select * from tasks";
        var rows = await conn.query(query);
        res.send(rows);
    } catch (err) {
        throw err;
    } finally {
        if (conn) return conn.release();
    }
});

// POST 
router.post("/", async (req, res, next) => {
    let task = req.body;
    let conn;
    try {
        conn = await pool.getConnection();
        var query = "insert into tasks (description) values (?)";
        var result = await conn.query(query, [task.description]);
        res.send(result);
    } catch (err) {
        throw err;
    } finally {
        if (conn) return conn.release();
    }
});

// PUT 
router.put("/", async (req, res, next) => {
    let task = req.body;
    let conn;
    try {
        conn = await pool.getConnection();
        var query = "update tasks set description = ?, completed = ? where id = ?";
        var result = await conn.query(query, [task.description, task.completed, task.id]);
        res.send(result);
    } catch (err) {
        throw err;
    } finally {
        if (conn) return conn.release();
    }
});

// DELETE
router.delete("/", async (req, res, next) => {
    let id = req.query.id;
    let conn;
    try {
        conn = await pool.getConnection();
        var query = "delete from tasks where id = ?";
        var result = await conn.query(query, [id]);
        res.send(result);
    } catch (err) {
        throw err;
    } finally {
        if (conn) return conn.release();
    }
});

module.exports = router;