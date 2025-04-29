# 🚀 Foro Hub API

## 📝 Descripción
Este proyecto es un desafío que forma parte del programa **Oracle Next Education**. Consiste en la creación de una API destinada a una aplicación de tipo **Foro**.

## 🛠️ Tecnologías utilizadas
- **Lenguaje**: Java ☕
- **Framework**: Spring Framework, Maven 🌱
- **Base de datos**: PostgreSQL 🐘
- **Autenticación**: JWToken, Bearer Key (Stateless) 🔑
- **Otros**: IntelliJ, Hibernate, JPA

---

## 📖 Uso y Endpoints

### 🔒 Autenticación
#### `POST /login`

![🔑](https://github.com/user-attachments/assets/28aed387-5406-4366-baa5-d3bd5eaf0b00)

**Descripción:** Permite a los usuarios registrados autenticarse en la base de datos.

- **Request Body:**
  ```json
  {
    "login": "[usuario]",
    "clave": "[contraseña]"
  }
  ```
- **Response:**
  ```json
  {
    "jwTtoken": "[token de autenticación]"
  }
  ```

---

### 🗂️ Operaciones sobre tópicos

#### ➕ `POST /topicos`

![📋](https://github.com/user-attachments/assets/c2d4d7d1-8e9e-4313-a9fe-3ac2e94cd700)

**Descripción:** Registra un nuevo tópico.

**Restricciones:**
- El tópico registrado no puede ser igual a uno existente (mismo título y mensaje).
- El `autorId` debe ser una ID de usuario válida.

- **Request Body:**
  ```json
  {
    "titulo": "[título del tópico]",
    "mensaje": "[contenido del tópico]",
    "fechaCreacion": "[YYYY-MM-DDTHH:MM:SSZ]",
    "status": "[ABIERTO/CERRADO/PENDIENTE/RESUELTO/EN_PROGRESO]",
    "autorId": "[Id del autor del tópico]"
  }
  ```
- **Response:**
  ```json
  {
    "id": [id del tópico creado],
    "titulo": "[título del tópico]",
    "mensaje": "[contenido del tópico]",
    "nombreAutor": "[Nombre de usuario del autor]"
  }
  ```

---

#### 📋 `GET /topicos`

![📜](https://github.com/user-attachments/assets/ea271d48-9d51-46af-918f-a7953da0a132)

**Descripción:** Obtiene todos los tópicos registrados.

- **Response:**
  ```json
  [
    {
      "id": [id del tópico],
      "titulo": "[título del tópico]",
      "mensaje": "[contenido del tópico]",
      "fechaCreacion": "[YYYY-MM-DDTHH:MM:SSZ]",
      "status": "[ABIERTO/CERRADO/PENDIENTE/RESUELTO/EN_PROGRESO]",
      "autorId": "[Id del autor del tópico]"
    }
  ]
  ```

---

#### 🔍 `GET /topicos/{id}`

![🔎](https://github.com/user-attachments/assets/bdca6db6-aa35-4311-8bb9-fbc5c7f81937)

**Descripción:** Obtiene un tópico específico por su ID.

- **Response:**
  ```json
  {
    "id": [id del tópico],
    "titulo": "[título del tópico]",
    "mensaje": "[contenido del tópico]",
    "fechaCreacion": "[YYYY-MM-DDTHH:MM:SSZ]",
    "status": "[ABIERTO/CERRADO/PENDIENTE/RESUELTO/EN_PROGRESO]",
    "autorId": "[Id del autor del tópico]"
  }
  ```

---

#### ✏️ `PUT /topicos/{id}`

![🛠️](https://github.com/user-attachments/assets/ddba8b87-f218-4553-9b3e-791420ad9820)

**Descripción:** Actualiza un tópico existente. Todos los campos son opcionales.

**Restricciones:**
- El tópico actualizado no puede ser igual a uno existente (mismo título y mensaje).
- El `autorId` debe ser una ID de usuario válida.

- **Request Body:**
  ```json
  {
    "titulo": "[título del tópico]",
    "mensaje": "[contenido del tópico]",
    "fechaCreacion": "[YYYY-MM-DDTHH:MM:SSZ]",
    "status": "[ABIERTO/CERRADO/PENDIENTE/RESUELTO/EN_PROGRESO]",
    "autorId": "[Id del autor del tópico]"
  }
  ```
- **Response:**
  ```json
  {
    "id": [id del tópico actualizado],
    "titulo": "[título del tópico actualizado]",
    "mensaje": "[contenido del tópico actualizado]",
    "fechaCreacion": "[YYYY-MM-DDTHH:MM:SSZ]",
    "status": "[ABIERTO/CERRADO/PENDIENTE/RESUELTO/EN_PROGRESO]",
    "autorId": "[Id del autor actualizado]"
  }
  ```

---

#### 🗑️ `DELETE /topicos/{id}`

![❌](https://github.com/user-attachments/assets/565073b4-e566-484d-ab39-1dcc41d44de3)

**Descripción:** Elimina un tópico por su ID.

- **Response:**
  ```json
  Sin respuesta
  ```


