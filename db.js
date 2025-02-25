
const { Pool } = require('pg');

// Configuración de la conexión con variables de entorno
const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'citas_medicas',
    password: '1006521620Jhoer',
    port: '5432'
});

// Verificar conexión
pool.connect()
    .then(() => console.log(' Conexión a PostgreSQL exitosa'))
    .catch(err => console.error(' Error de conexión:', err.stack));

module.exports = pool;
