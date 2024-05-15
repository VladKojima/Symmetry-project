import React, { useEffect, useState } from "react";
import { Button } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import axios from 'axios';

function NavbarStudent() {
    const logoutEndpoint = () => {
        axios.post("http://localhost:8080/api/auth/logout", {}, {
            headers: {
              "Content-Type": "application/json",
            },
            withCredentials: true
          })
          .then((response) => {
            window.location.href = "/"
          })
          .catch((error) => {
            console.error("Произошла ошибка:", error);
          });
    };

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light align-items-start p-0">
        <div className="container-fluid p-5 flex-column">
            <h3 className="navbar-brand mb-4 me-0" to="/">Меню модератора</h3>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse w-100" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0 flex-column w-100">
                    <li className="nav-item">
                        <NavLink className="nav-link" activeclassname="active" to="/moderator">Профиль</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeclassname="active" to="/news">Новости</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeclassname="active" to="/students">Студенты</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeclassname="active" to="/companies">Компании</NavLink>
                    </li>
                    <li className="nav-item mt-4">
                        <Button onClick={logoutEndpoint} className='w-100 btn-spec'>Выйти</Button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  );
}

export default NavbarStudent;
