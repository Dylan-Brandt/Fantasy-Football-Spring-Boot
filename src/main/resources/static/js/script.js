function sortTable(colIndex) {
	var table = document.getElementById("playersTable");
	var rows = Array.prototype.slice.call(table.rows, 1);
	var asc = table.getAttribute("data-asc") === "true";
	rows.sort(function(row1, row2) {
		var cell1 = row1.cells[colIndex].textContent.trim();
		var cell2 = row2.cells[colIndex].textContent.trim();
		var result;
		if (!isNaN(parseFloat(cell1)) && !isNaN(parseFloat(cell2))) {
			result = parseFloat(cell1) - parseFloat(cell2);
		} else {
			result = cell1.localeCompare(cell2);
		}
		return asc ? result : -result;
	});
	for (var i = 0; i < rows.length; i++) {
		table.tBodies[0].appendChild(rows[i]);
	}
	table.setAttribute("data-asc", !asc);
}

function filterTableByName() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("nameSearch");
  filter = input.value.toUpperCase();
  table = document.getElementById("playersTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}