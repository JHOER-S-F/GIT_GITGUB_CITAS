const express = require('express');
const router = express.Router();
const db = require('../db');

router.post('/', (req, res) => {
    const { nombre, apellido, especialidad, licencia, telefono, email } = req.body;
    const sql = 'INSERT INTO medico SET ?';
    db.query(sql, { nombre, apellido, especialidad, licencia, telefono, email }, (err, result) => {
        if (err) return res.status(500).send(err);
        res.send('Médico agregado');
    });
});

router.get('/', (req, res) => {
    db.query('SELECT * FROM medico', (err, results) => {
        if (err) return res.status(500).send(err);
        res.json(results);
    });
});

router.get('/:id', (req, res) => {
    db.query('SELECT * FROM medico WHERE id = ?', [req.params.id], (err, result) => {
        if (err) return res.status(500).send(err);
        res.json(result[0]);
    });
});

router.put('/:id', (req, res) => {
    const { especialidad, telefono } = req.body;
    db.query('UPDATE medico SET ? WHERE id = ?', [{ especialidad, telefono }, req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Médico actualizado');
    });
});

router.delete('/:id', (req, res) => {
    db.query('DELETE FROM medico WHERE id = ?', [req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Médico eliminado');
    });
});

module.exports = router;
