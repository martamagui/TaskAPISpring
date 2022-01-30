# TaskAPISpring
</br></br>

# 📃 TaskList Request 📃

</br>

**(@GET)** List of all TaskList -> */api/list*
```json
[
    {
        "listId": 15,
        "name": "Nueva",
        "userFk": 1
    },
    {
        "listId": 16,
        "name": "n",
        "userFk": 1
    }
]
```

**(@POST)** TaskList -> */api/list*

Body

```json
    {
        "listId": 15,
        "name": "Nueva",
        "userFk": 1
    }
```
**(@DELETE)** TaskList(retorna el id del elimnado) -> */api/list/{list Id}*
```json
1
```
</br></br>

# ✏ Task ✏

**(@GET)** List of all Task -> *api/tasks*
```json
[
   {
        "taskId": 15,
        "title": "Aspirar",
        "description": "Aaaaaa",
        "state": "Terminado",
        "listIdFk": 15
    },
    {
        "taskId": 20,
        "title": "Ayudar a Cely",
        "description": "Cely diosa latina",
        "state": "Pendiente",
        "listIdFk": 15
    }
]
```
**(@GET)** List of all Task filtered by List ID -> *api/tasks/bylistId/{List ID}*
```json
[
   {
        "taskId": 15,
        "title": "Aspirar",
        "description": "Aaaaaa",
        "state": "Terminado",
        "listIdFk": 15
    },
    {
        "taskId": 20,
        "title": "Ayudar a Cely",
        "description": "Cely diosa latina",
        "state": "Pendiente",
        "listIdFk": 15
    }
]
```
**(@GET)** Task filtered by ID -> *api/tasks/{List ID}*
```json
   {
        "taskId": 15,
        "title": "Aspirar",
        "description": "Aaaaaa",
        "state": "Terminado",
        "listIdFk": 15
    }
```
**(@GET)** Returns the last Id -> *api/tasks/getmyTaskId*
```json
  1
```

**(@POST)** Add Task -> */api/tasks*
</br>
Body a enviar
```json
     {
        "taskId": 15,
        "title": "Aspirar",
        "description": "Aaaaaa",
        "state": "Terminado",
        "listIdFk": 15
    }
```
Retorna
```json
    true
```

**(@DELETE)** TaskList(retorna el id del elimnado) -> *api/tasks/{Task Id}*
```json
15
```
**(@PUT)** TaskList(retorna el id del elimnado) -> *api/tasks/{Task Id}*
```json
{
        "taskId": 15,
        "title": "Aspirar",
        "description": "Aaaaaa",
        "state": "Terminado",
    }
```
