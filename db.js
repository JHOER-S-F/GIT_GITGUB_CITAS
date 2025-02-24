require('dotenv').config();
const { Pool } = require('pg');

// Configuración de la conexión con variables de entorno
const pool = new Pool({
    user: process.env.DB_USER,
    host: process.env.DB_HOST,
    database: process.env.DB_NAME,
    password: process.env.DB_PASSWORD,
    port: process.env.DB_PORT
});

// Verificar conexión
pool.connect()
    .then(() => console.log(' Conexión a PostgreSQL exitosa'))
    .catch(err => console.error(' Error de conexión:', err.stack));

module.exports = pool;
