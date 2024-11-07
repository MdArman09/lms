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

    if (branches[program]) { // Check if the selected program exists in branches
        branches[program].forEach(branch => {
            const option = document.createElement('option');
            option.value = branch.toLowerCase().replace(/\s+/g, '');
            option.textContent = branch;
            branchSelect.appendChild(option);
        });
    } else {
        console.warn("No branches found for the selected program:", program);
    }
}

// Initialize the branches dropdown on page load
document.addEventListener('DOMContentLoaded', function() {
    // Ensure a valid initial program selection
    document.getElementById('program').selectedIndex = 1; // Set default to first valid option
    updateBranches();

    // Ensure update on program change
    document.getElementById('program').addEventListener('change', updateBranches);
});

// Password toggle functionality
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
