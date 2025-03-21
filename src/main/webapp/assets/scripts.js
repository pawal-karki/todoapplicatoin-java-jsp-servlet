// Wait for the DOM to be fully loaded
document.addEventListener('DOMContentLoaded', function() {
    // Auto-hide success and error messages after 5 seconds
    const messages = document.querySelectorAll('.success-message, .error-message');
    
    messages.forEach(function(message) {
        setTimeout(function() {
            message.style.opacity = '0';
            setTimeout(function() {
                message.style.display = 'none';
            }, 500);
        }, 5000);
    });
    
    // Form validation for add-todo form
    const addTodoForm = document.querySelector('form[action="AddTodoServlet"]');
    
    if (addTodoForm) {
        addTodoForm.addEventListener('submit', function(event) {
            const titleInput = document.getElementById('title');
            
            if (!titleInput.value.trim()) {
                event.preventDefault();
                
                // Create error message if it doesn't exist
                let errorDiv = document.querySelector('.error-message');
                
                if (!errorDiv) {
                    errorDiv = document.createElement('div');
                    errorDiv.className = 'error-message';
                    const errorP = document.createElement('p');
                    errorP.textContent = 'Title cannot be empty';
                    errorDiv.appendChild(errorP);
                    
                    // Insert at the top of the form
                    addTodoForm.parentNode.insertBefore(errorDiv, addTodoForm);
                } else {
                    errorDiv.querySelector('p').textContent = 'Title cannot be empty';
                    errorDiv.style.display = 'block';
                    errorDiv.style.opacity = '1';
                }
                
                // Highlight the input field
                titleInput.classList.add('error');
                titleInput.focus();
            }
        });
    }
    
    // Confirm delete action
    const deleteForms = document.querySelectorAll('.delete-form');
    
    deleteForms.forEach(function(form) {
        form.addEventListener('submit', function(event) {
            const confirmed = confirm('Are you sure you want to delete this todo?');
            
            if (!confirmed) {
                event.preventDefault();
            }
        });
    });
    
    // Add visual feedback when clicking buttons
    const buttons = document.querySelectorAll('.btn');
    
    buttons.forEach(function(button) {
        button.addEventListener('click', function() {
            this.classList.add('btn-active');
            
            setTimeout(() => {
                this.classList.remove('btn-active');
            }, 200);
        });
    });
    
    // Add CSS for the visual feedback
    const style = document.createElement('style');
    style.textContent = `
        .btn-active {
            transform: scale(0.98);
            box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
        }
        
        .error {
            border-color: #dc3545 !important;
            box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.25);
        }
    `;
    document.head.appendChild(style);
});