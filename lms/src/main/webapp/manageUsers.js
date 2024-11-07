const branches = {
    btech: [
        "Computer Science Engineering",
        "Electronics and Communication Engineering",
        "Aerospace Engineering",
        "Mechanical Engineering",
        "Electrical and Electronics Engineering",
        "Civil Engineering"
    ],
    mtech: [
        "Computer Science Engineering",
        "VLSI Design",
        "Thermal Engineering",
        "Structural Engineering"
    ],
    phd: [
        "Computer Science Engineering",
        "Electronics Engineering",
        "Mechanical Engineering",
        "Civil Engineering"
    ]
};

function updateBranches() {
    const program = document.getElementById('program').value;
    const branchSelect = document.getElementById('branch');
    branchSelect.innerHTML = '';

    // Add the relevant branches based on the selected program
    branches[program].forEach(branches => {
        const option = document.createElement('option');
        option.value = branches.toLowerCase().replace(/\s+/g, '');
        option.textContent = branches;
        branchSelect.appendChild(option);
    });
}

// Initialize the branches dropdown on page load
document.addEventListener('DOMContentLoaded', function() {
    // Initial update of branches
    updateBranches();

    // Ensure update on program change
    document.getElementById('program').addEventListener('change', updateBranches);
});


function validateForm() {
    const userName = document.getElementById('Name').value;
    const userEmail = document.getElementById('Email').value;
    const userPassword = document.getElementById('Password').value;
	const userRegNo = parseInt(document.getElementById('RegdNo').value);
	const userPhNo = document.getElementById('PhNo').value;
	const userBranch = document.getElementById('Branch').value;
	const userProgram = document.getElementById('Program').value;
	const userYear = document.getElementById('Year').value;
	const userRole = document.getElementById('Role').value;

    // Check if any fields are empty
    if (!userName || !userEmail || !userPassword || !userRegNo || !userPhNo || !userBranch || !userProgram || !userYear || !userRole) {
		alert("All fields are required!");
		return false;
    }

    // If all fields are filled, proceed with form submission
    return true;
}

const passwordInput = document.getElementById('password');
    const toggleIcon = document.getElementById('toggle');

    if (passwordInput && toggleIcon) {
        toggleIcon.addEventListener('click', function() {
            // Toggle password visibility
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.textContent = 'visibility';
            } else {
                passwordInput.type = 'password';
                toggleIcon.textContent = 'visibility_off';  
            }
        });
    } else {
        console.error("Password input or toggle icon not found");
    }