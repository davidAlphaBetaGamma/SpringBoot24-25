let shoppingCart = [];

async function getAllProducts() {
    const response = await fetch('http://localhost:8080/api/getAllProducts');
    const products = await response.json();

    const productsContainer = document.getElementById('products');
    productsContainer.innerHTML = '';

    products.forEach(product => {
        const productElement = document.createElement('div');
        productElement.innerHTML = `
            <p>${product.name} - ${product.price} €</p>
            <label for="quantity_${product.id}">Menge:</label>
            <input type="number" id="quantity_${product.id}" value="1">
            <button onclick="addToCart(${product.id}, '${product.name}', ${product.price})">In den Warenkorb</button>
        `;
        productsContainer.appendChild(productElement);
    });
}

function addToCart(productId, productName, productPrice) {
    const quantityInput = document.getElementById(`quantity_${productId}`);
    const quantity = parseInt(quantityInput.value);

    const existingCartItem = shoppingCart.find(item => item.productId === productId);
    if (existingCartItem) {
        existingCartItem.quantity += quantity;
    } else {
        shoppingCart.push({
            productId: productId, productName: productName, quantity: quantity, price: productPrice
        });
    }

    updateCartUI();
}

function updateCartUI() {
    const cartItemsContainer = document.getElementById('cartItems');
    cartItemsContainer.innerHTML = '';
    let totalPrice = 0;

    shoppingCart.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.productName}</td>
            <td>${item.price} €</td>
            <td>${item.quantity}</td>
            <td>${item.price * item.quantity} €</td>
        `;
        cartItemsContainer.appendChild(row);
        totalPrice += item.price * item.quantity;
    });

    document.getElementById('totalPrice').innerText = totalPrice;
}

function showShoppingCart() {
    document.getElementById('products').style.display = 'none';
    document.getElementById('shoppingCart').style.display = 'block';
}

async function placeOrder() {
    const order = {
        orderDescription: 'Test Order',
        cartItems: shoppingCart,
        customerEmail: 'test@example.com',
        customerName: 'John Doe'
    };

    try {
        const response = await fetch('http://localhost:8080/api/placeOrder', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(order)
        });

        if (response.ok) {
            const result = await response.json();
            alert(`Bestellung erfolgreich abgeschlossen!\nProdukt: ${result.orderDescription}\nMenge: ${result.amount}\nPreis: ${result.amount}`);

            // Hier können Sie Logik hinzufügen, um den Warenkorb zu leeren
            shoppingCart = [];
            updateCartUI();

            // Zeigen Sie die Zahlungsmethoden an oder führen Sie die entsprechenden Aktionen durch

        } else {
            alert('Fehler beim Abschließen der Bestellung');
        }
    } catch (error) {
        console.error('Fehler beim API-Aufruf', error);
    }
}

function cancelOrder() {
    // Logik zum Entfernen der Produkte vom Warenkorb
    shoppingCart = [];
    updateCartUI();

    // Hier können Sie Logik hinzufügen, um zur Dashboard-Seite oder zu den Produkten Ihrer Kollegin weiterzuleiten
    // window.location.href = '/dashboard'; // Beispiel für eine Weiterleitung zur Dashboard-Seite
    // oder
     window.location.href = 'http://localhost:8080/products'; // Beispiel für eine Weiterleitung zu den Produkten Ihrer Kollegin
}

// Funktion zum Zurücksetzen der Benutzeroberfläche
function resetUI() {
    shoppingCart = [];
    document.getElementById('products').style.display = 'block';
    document.getElementById('shoppingCart').style.display = 'none';
    getAllProducts();
    updateCartUI();
}

