import React from 'react';
import { Form, Button } from 'react-bootstrap';
import './styles.css'; // Importă stilurile

const Login = () => {
    return (
        <div className='d-flex justify-content-center align-items-center vh-100 pink-background'>
            <img src='logo.png' alt='Logo' className='loginPhoto' />
            <div className='bg-white p-3 rounded w-25'>
                <h2>Login</h2>
                <form action="">
                    <div className='mb-3'>
                        <label htmlFor="email"><strong>Email</strong></label>
                        <input type="email" placeholder='Enter Email' name='email'
                               className='form-control rounded-0'/>

                    </div>
                    <div className='mb-3'>
                        <label htmlFor="password"><strong>Password</strong></label>
                        <input type="password" placeholder='Enter password' name='password'
                               className='form-control rounded-0' />

                    </div>
                    <button type='submit' className='btn btn-success w-100'>Log in</button>
                </form>
            </div>
        </div>

    )
}

export default Login;