import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [products, setProducts] = useState([]);
  const [keyword, setKeyword] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/api/products")
      .then(res => setProducts(res.data));
  }, []);

  const search = () => {
    axios.get(`http://localhost:8080/api/products/search?keyword=${keyword}`)
      .then(res => setProducts(res.data));
  };

  return (
    <div className="p-8">
      <h1 className="text-2xl font-bold">E-commerce Product Catalog</h1>
      <div className="flex mt-4">
        <input
          className="border p-2 flex-grow"
          placeholder="Search products..."
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />
        <button className="bg-blue-500 text-white px-4 ml-2" onClick={search}>
          Search
        </button>
      </div>
      <div className="grid grid-cols-3 gap-4 mt-6">
        {products.map(p => (
          <div key={p.id} className="p-4 border rounded shadow">
            <h2 className="font-semibold">{p.name}</h2>
            <p>{p.category}</p>
            <p>${p.price}</p>
            <p className="text-sm">{p.description}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;