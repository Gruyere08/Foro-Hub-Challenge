
-- Create table for Usuario
CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    correo_electronico VARCHAR(255),
    contrasena VARCHAR(255)
);

-- Create table for Topico
CREATE TABLE topicos (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    mensaje TEXT,
    fecha_creacion TIMESTAMP,
    status VARCHAR(255),
    autor_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);

-- Create table for Respuesta
CREATE TABLE respuestas (
    id BIGSERIAL PRIMARY KEY,
    mensaje TEXT,
    topico_id BIGINT,
    fecha_creacion TIMESTAMP,
    autor_id BIGINT,
    solucion BOOLEAN,
    FOREIGN KEY (topico_id) REFERENCES topicos(id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);

