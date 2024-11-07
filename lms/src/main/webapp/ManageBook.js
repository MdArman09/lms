function validateForm() {
    const acc_no = document.getElementById('AccNumber').value;
    const bookTitle = document.getElementById('bookTitle').value;
    const author = document.getElementById('author').value;
    const publisher = document.getElementById('publisher').value;

    if (!acc_no || !bookTitle || !author || !publisher) {
        alert("All fields are required!");
        return false;
    }

    return true;
}