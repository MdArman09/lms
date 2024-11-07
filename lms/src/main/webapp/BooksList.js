function searchBook() {
    const input = document.getElementById("searchInput");
    const filter = input.value.toUpperCase();
    const table = document.getElementById("bookTable");
    const tr = table.getElementsByTagName("tr");

	for (let i = 1; i < tr.length; i++) {
	       const td = tr[i].getElementsByTagName("td")[1];
	       if (td) {
	           const txtValue = td.textContent || td.innerText;
	           tr[i].style.display = txtValue.toUpperCase().indexOf(filter) > -1 ? "" : "none";
	       }
	   }
}
