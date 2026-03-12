fetch("http://localhost:8080/products")
.then(response => response.json())
.then(data => {

let productList = document.getElementById("products");

productList.innerHTML = "";

data.forEach(product => {

let item = `
<div class="product-card">

<img src="${product.imageUrl}" width="200">

<h3>${product.name}</h3>

<p>Price: ${product.price}</p>

<button onclick="addToCart(${product.id})">Add to Cart</button>

</div>
`;

productList.innerHTML += item;

});

});

function addToCart(productId){

let userId = localStorage.getItem("userId");

if(!userId){
alert("Please login first");
window.location.href="login.html";
return;
}

fetch("http://localhost:8080/cart/add?userId="+userId+"&productId="+productId,{
method:"POST"
})

.then(response=>response.json())

.then(data=>{
console.log("Cart updated:",data);
alert("Product added to cart");
})

.catch(error=>{
console.log("Error:",error);
});

}