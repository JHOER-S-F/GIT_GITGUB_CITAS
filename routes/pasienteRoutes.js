const express = require('express');
const router = express.Router();
const db = require('../db'); // Importa la conexión

// Crear un paciente
router.post('/', (req, res) => {
    const { nombre, apellido, documento, telefono, email, fecha_nacimiento, direccion } = req.body;
    const sql = 'INSERT INTO paciente SET ?';
    db.query(sql, { nombre, apellido, documento, telefono, email, fecha_nacimiento, direccion }, (err, result) => {
        if (err) return res.status(500).send(err);
        res.send('Paciente agregado');
    });
});

// Obtener todos los pacientes
router.get('/', (req, res) => {
    db.query('SELECT * FROM paciente', (err, results) => {
        if (err) return res.status(500).send(err);
        res.json(results);
    });
});

// Obtener un paciente por ID
router.get('/:id', (req, res) => {
    db.query('SELECT * FROM paciente WHERE id = ?', [req.params.id], (err, result) => {
        if (err) return res.status(500).send(err);
        res.json(result[0]);
    });
});

// Actualizar un paciente
router.put('/:id', (req, res) => {
    const { nombre, apellido, telefono } = req.body;
    db.query('UPDATE paciente SET ? WHERE id = ?', [{ nombre, apellido, telefono }, req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Paciente actualizado');
    });
});

// Eliminar un paciente
router.delete('/:id', (req, res) => {
    db.query('DELETE FROM paciente WHERE id = ?', [req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.send('Paciente eliminado');
    });
});

module.exports = router;
