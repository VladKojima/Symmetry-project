import { useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import NavbarStudent from "./component/NavbarStudent";
import photo from "../img/photo_2023-10-15_01-12-32.jpg";
import './registr.css';
import '../css/profile.css'; 

function Student() {
    return (
        <div className="container-fluid">
            <div className="row g-4">
                <div className="col-lg-3 px-0">
                    <NavbarStudent/>
                </div>
                <div className="col-lg-9">
                    <div className="container px-4 py-5">
                        <div className="row">
                            <div className="col-lg-3">
                                <div className="profile-photo-box">
                                    <img src={photo} alt="" className="profile-photo img-fluid"/>
                                </div>
                            </div>
                            <div className="col-lg-9">
                                <p className="fs-24">Реброва Мария Алексеевна</p>
                                <hr/>
                                <div className="row g-4">
                                    <div className="col-lg-6">
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Телефон: </p>
                                            <p>+79277896528</p>
                                        </div>
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Email: </p>
                                            <p>q1@gmail.com</p>
                                        </div>
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Telegram: </p>
                                            <p>@tg</p>
                                        </div>
                                    </div>
                                    <div className="col-lg-6">
                                        
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
export default Student;


