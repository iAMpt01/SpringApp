import React from 'react';
import { BrowserRouter, Routes , Route } from "react-router-dom";
import Login from './Login'; // Import your Login component
import Registration from './Register'; // Import your Registration component

function App() {
    return (
        <BrowserRouter>
            <Routes>

                <Route path='/' element={<Login />}> </Route>
                <Route path='/register' element={<Registration />}> </Route>

            </Routes>
</BrowserRouter>
    );
}

export default App;
