import { BrowserRouter, Routes , Route } from "react-router-dom";
import React from 'react'
import Login from './Login';

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login />}></Route>

        </Routes>
      </BrowserRouter>
  );
}

export default App;
