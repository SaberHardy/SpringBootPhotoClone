For delete item in javascript with an API call, run this function:
(async function deletePhoto(id) {
    await fetch('http://127.0.0.1:8080/photos/' + id, {
    method: "DELETE"
})})("5");

[//]: # (Create a photo)

(async function createPhoto() {
    let photo = {"fileName": "test.jpg"};
        await fetch('http://127.0.0.1:8080/photos',{
        method: "POST",
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    },
        body: JSON.stringify(photo)
    }).then(result => result.text()).then(text => alert(text));
})();