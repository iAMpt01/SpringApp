import React from 'react';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom
import './styles.css';

const Registration = () => {
    return (
        <div className='d-flex justify-content-center align-items-center vh-100 pink-background'>
            <img src='logo.png' alt='Logo' className='loginPhoto' />
            <div className='bg-white p-3 rounded w-25'>
                <h2>Create Account</h2>
                <form action="">
                    <div className='mb-3'>
                        <label htmlFor="email"><strong>Email</strong></label>
                        <input type="email" placeholder='Enter Email' name='email' className='form-control rounded-0'/>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="password"><strong>Password</strong></label>
                        <input type="password" placeholder='Enter password' name='password' className='form-control rounded-0' />
                    </div>
                    <button type='submit' className='btn btn-primary w-100'>Create Account</button>
                </form>
            </div>
            <div className='mt-3'>
                <Link to="/login">Already have an account? Log in</Link>
            </div>
        </div>
    )
}

export default Registration;
