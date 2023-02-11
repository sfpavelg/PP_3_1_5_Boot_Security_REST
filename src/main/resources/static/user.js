const url = 'http://localhost:8080/api/users/authUser'
const t_body = document.getElementById(`tbody`)

async function getAuthUser() {
    let userPage = await fetch(url);
    let user = await userPage.json();
    let user_table = "";
    let roles = [];
    for (let role of user.roles) {
        roles.push(" " + role.name.toString().replaceAll('ROLE_', ''))
    }
    user_table =
        `<tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.age}</td>
            <td>${user.username}</td>
            <td>${roles}</td>
        </tr>`
    t_body.innerHTML = user_table;
}

getAuthUser();
