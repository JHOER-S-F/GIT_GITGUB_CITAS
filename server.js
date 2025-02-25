require('dotenv').config();
const express = require('express');
const cors = require('cors');

const port = 3000 ;

const app = express();
app.use(express.json());
app.use(cors());





const pacienteRoutes = require('./routes/pasienteRoutes');
const medicoRoutes = require('./routes/medicoRoutes');
const citaRoutes = require('./routes/citaRoutes');

app.(req,res)=>{
    ("pagina principal")
})
app.use('/pacientes', pacienteRoutes);
app.use('/medicos', medicoRoutes);
app.use('/citas', citaRoutes);


app.listen(port,()=>{
    console.log(`Servidor corriendo en http://localhost:${port}`)
});