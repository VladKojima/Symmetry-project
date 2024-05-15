import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarModerator from "./component/NavbarModerator";
import photo from "../img/def-card.png";
import './registr.css';
import '../css/profile.css'; 

function Students() {
    const [user, setUser] = useState('');

    useEffect(() => {
        fetch(`http://localhost:8080/api/student`, {
          method: 'GET',
          credentials: 'include'
        })
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.json();
          })
          .then(res => setUser(res))
          .catch(error => console.error('Error fetching films:', error));
      }, [setUser]);

    return (
        <div className="container-fluid">
            <div className="row g-4">
                <div className="col-lg-3 px-0">
                    <NavbarModerator/>
                </div>
                <div className="col-lg-9">
                    <div className="row">
                        <div className="col-lg-4"></div>
                    </div>
                    <div className="container px-4 py-5">
                    <div className="row g-3 pb-5">
                        {/* <div className="col-lg-4">
                            <label htmlFor="searchInput" className="d-none">Поиск по названию:</label>
                            <input className="form-control"
                            type="text"
                            id="searchInput"
                            value={searchTerm}
                            onChange={handleSearchChange}
                            placeholder="Поиск по названию"
                            />
                        </div>
                        <div className="col-lg-8">
                            <Select
                                id="selectInput"
                                value={selectedOption}
                                onChange={handleSelectChange}
                                options={options}
                                isMulti
                                placeholder="Выберите теги"
                            />
                        </div> */}
                         <div className="col-12">
                           <Button className="w-100"><NavLink to='/students/create'>Создать студента</NavLink></Button>
                        </div>
                        </div>
                        <div className="row row-cols-lg-3 row-cols-md-2 g-4">
                            {Array.isArray(user) ? user.map((f, index) => (
                                <div className="col" key={index}>
                                    <div className="card">
                                        <div className="profile-photo-box mx-auto mt-4">
                                            <img src={photo} alt="Default Profile" className="profile-photo img-fluid"/>
                                        </div>
                                        <div className="card-body">
                                            <h5 className="card-title">{f.surname} {f.name} {f.patronymic}</h5>
                                        </div>
                                    </div>
                                </div>
                            )) : null}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Students;


