import React from 'react';
import { NavLink } from 'react-router-dom';

function NavbarStudent() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light p-0">
        <div className="container-fluid p-5 flex-column">
            <h3 className="navbar-brand mb-4 me-0" to="/">Меню студента</h3>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse w-100" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0 flex-column w-100">
                    <li className="nav-item">
                        <NavLink className="nav-link" activeClassName="active" to="/student">Резюме</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeClassName="active" to="/news">Новости</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeClassName="active" to="/vacancies">Вакансии</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" activeClassName="active" to="/company">Компании</NavLink>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  );
}

export default NavbarStudent;
