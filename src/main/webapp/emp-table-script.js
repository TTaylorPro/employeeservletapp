console.log('Hello JavaScript World!!!');

let table = document.querySelector('table');

let button = document.getElementById('all-emps');



button.addEventListener('click', fetchEmps);

function buildTable(data){
    console.log('build table method engaged');

    console.log(data);

    let header = document.createElement('thread');
    let headerRow = document.createElement('tr');

    header.appendChild(headerRow);

    table.appendChild(header);

    let th1 = document.createElement('th');
    th1.innerHTML = "First Name";

    let th2 = document.createElement('th');
    th2.innerHTML = "Last Name";

    let th3 = document.createElement('th');
    th3.innerHTML = "Username";

    headerRow.appendChild(th1);
    headerRow.appendChild(th2);
    headerRow.appendChild(th3);

    data.forEach(e => {

        console.log(e);

        let row = document.createElement('tr');
        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');

        td1.innerHTML = e.firstName;
        td2.innerHTML = e.lastName;
        td3.innerHTML = e.username;

        row.appendChild(td1);
        row.appendChild(td2);
        row.appendChild(td3);

        table.appendChild(row);
    });
}

function fetchEmps(){

    let hostname = window.location.hostname;

    fetch(`http://${hostname}/employee-servlet-app/employees`)
    .then(response => response.json())

    .then(obj => console.log (obj))
    .then(buildTable);
}

//let user ={
    //firstname: "first",
    //lastname: "last",
    //username: "bob",
    //password: "secretpass"
//}

function sayHello(){
    console.log('Hello there!');
}
