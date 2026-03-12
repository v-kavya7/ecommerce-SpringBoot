let userId = localStorage.getItem("userId");

fetch("http://localhost:8080/cart/" + userId)
.then(response => response.json())
.then(data => {

let cartList = document.getElementById("cartItems");

cartList.innerHTML = "";

if(data.length === 0){
cartList.innerHTML = "<h2>Cart is empty</h2>";
return;
}

data.forEach(item => {

let product = item.product;

let row = `
<div class="cart-item">

<img src="${product.imageUrl}" width="150">

<h3>${product.name}</h3>

<p>Price: ₹${product.price}</p>

<p>Quantity: ${item.quantity}</p>

<button onclick="removeItem(${item.id})">Remove</button>

</div>
`;

cartList.innerHTML += row;

});

});

function removeItem(cartId){

fetch("http://localhost:8080/cart/remove/" + cartId,{
method:"DELETE"
})
.then(()=>{

alert("Item removed");

location.reload();

});

}
function checkout(){

let userId = localStorage.getItem("userId");

fetch("http://localhost:8080/orders/checkout?userId="+userId,{
method:"POST"
})
.then(response=>response.json())
.then(data=>{

alert("Order placed successfully!");

localStorage.removeItem("cart");

window.location.href="index.html";

});

}