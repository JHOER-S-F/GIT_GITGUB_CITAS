const express = require('express');
const router = express.Router();
const db = require('../db');

router.post('/', (req, res) => {
    const { paciente_id, medico_id, fecha_hora, motivo, estado, observaciones } = req.body;
    const sql = 'INSERT INTO cita SET ?';
    db.query(sql, { paciente_id, medico_id, fecha_hora, motivo, estado, observaciones }, (err, result) => {
        if (err) return res.status(500).send(err);
        res.send('Cita creada');
    });
});

router.get('/', (req, res) => {
    db.query('SELECT * FROM cita', (err, results) => {
        if (err) return res.status(500).send(err);
        res.json(results);
    });
});

router.get('/:id', (req, res) => {
    db.query('SELECT * FROM cita WHERE id = ?', [req.params.id], (err, result) => {
        if (err) return res.status(500).send(err);
        res.json(result[0]);
    });
});

router.put('/:id', (req, res) => {
    const { estado, observaciones } = req.body;
    db.query('UPDATE cita SET ? WHERE id = ?', [{ estado, observaciones }, req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Cita actualizada');
    });
});

router.delete('/:id', (req, res) => {
    db.query('DELETE FROM cita WHERE id = ?', [req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Cita eliminada');
    });
});

module.exports = router;
