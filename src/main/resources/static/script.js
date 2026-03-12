fetch("http://localhost:8080/products")
.then(response => response.json())
.then(products => {

let container = document.getElementById("products");

products.forEach(product => {

let card = document.createElement("div");
card.className = "product-card";

card.innerHTML = `
<img src="${product.imageUrl}">
<div class="product-name">${product.name}</div>
<div class="product-price">₹${product.price}</div>
<button onclick="addToCart(${product.id}, ${product.price})">
Add to Cart
</button>
`;

container.appendChild(card);

});

});

function addToCart(productId, price){

fetch("http://localhost:8080/cart/add",{

method:"POST",
headers:{
"Content-Type":"application/json"
},

body: JSON.stringify({
userId:1,
productId:productId,
quantity:1,
price:price
})

})
.then(res => res.json())
.then(data => alert("Product added to cart"));
let cart = [];

fetch("http://localhost:8080/products")
.then(response => response.json())
.then(data => {

let productList = document.getElementById("products");

data.forEach(product => {

let item = `
<div>
<h3>${product.name}</h3>
<p>Price: ${product.price}</p>
<button onclick="addToCart(${product.id})">Add to Cart</button>
</div>
`;

productList.innerHTML += item;

});
});

function addToCart(id){
cart.push(id);
localStorage.setItem("cart", JSON.stringify(cart));
alert("Product added to cart");
}
function logout(){
localStorage.removeItem("userId");
window.location.href="login.html";
}
}
