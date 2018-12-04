function createTable(cadenas) {
    var table = document.getElementById("Table");
    table.innerHTML = "";
    //Crear encabezado de la tabla
    var tableHead = document.createElement("THEAD");
    tableHead.setAttribute("class", "thead-light");

    //Crear fila del encabezado
    var headersRow = document.createElement("TR");

    //crear los encabezados por columnas
    var headers = ["id", "Date", "String"];
    for (var h in headers) {
        var columnHeader = document.createElement("TH");
        columnHeader.setAttribute("scope", "col");
        columnHeader.innerHTML = headers[h];
        headersRow.appendChild(columnHeader);
    }

    //Agregar los elementos creados anteriormente
    tableHead.appendChild(headersRow);
    table.appendChild(tableHead);

    //Crear cuerpo de la tabla
    var tableBody = document.createElement("TBODY");
    for (var i in cadenas) {
        if (i < 10) {
            var bodyRow = document.createElement("TR");
            for (var j in cadenas[i]) {
                var columnRow = document.createElement("TD");
                columnRow.innerHTML = cadenas[i][j];
                bodyRow.appendChild(columnRow);
            }
            tableBody.appendChild(bodyRow);
        }
    }
    table.appendChild(tableBody);
}

function addString(str) {
    if (str != "" && str != " ") {
        axios.post('/strings', str, {headers: {'Content-Type': 'application/json'}}).then(function (response) {
            //console.log(response);
            getStrings();
        }).catch(function (error) {
            console.log(error);
        });
    } else {
        alert("Invalid string!");
    }
}

function getStrings() {
    axios.get('/strings').then(function (response) {
        createTable(response.data);
    }).catch(function (error) {
        console.log(error);
    })
}