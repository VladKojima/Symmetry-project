import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarModerator from "./component/NavbarModerator";
import photo from "../img/photo_2023-10-15_01-12-32.jpg";
import './registr.css';
import '../css/profile.css'; 

function Students() {
    const [user, setUser] = useState('');

    useEffect(() => {
        fetch(`http://localhost:8080/api/user`, {
          method: 'GET'
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
                        </div>
                        <div className="row g-4">
                            <div className="col-lg-4">
                                <div className="card pt-4">
                                    <div className="profile-photo-box mx-auto">
                                        <img src={photo} alt="Default Profile" className="profile-photo img-fluid"/>
                                    </div>
                                    <div className="card-body">
                                        <h5 className="card-title">Системный аналитик</h5>
                                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                        <div className="d-flex gap-2 flex-wrap mb-3">
                                            <p className="m-0 badge">Аналитика</p>
                                            <p className="m-0 badge">Java</p>
                                            <p className="m-0 badge">React</p>
                                            <p className="m-0 badge">Docker</p>
                                        </div>
                                        <a href="#" className="btn btn-primary">Откликнуться</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Students;


