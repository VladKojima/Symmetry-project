// import { useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarModerator from "./component/NavbarModerator";
import photo from "../img/photo_2023-10-15_01-12-32.jpg";
import './registr.css';
import '../css/profile.css'; 

function Student() {
    return (
        <div className="container-fluid">
            <div className="row g-4">
                <div className="col-lg-3 px-0">
                    <NavbarModerator/>
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
                                <div className="d-flex justify-content-between align-items-center">
                                    <p className="fs-24 m-0">Реброва Мария Алексеевна</p>
                                    <Button><NavLink to='/moderator/edit'>Редактировать</NavLink></Button>
                                </div>
                                <hr/>
                                <div className="row g-4">
                                    <div className="col-lg-6">
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Телефон: </p>
                                            <p className="fw-400">+79277896528</p>
                                        </div>
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Email: </p>
                                            <p className="fw-400">q1@gmail.com</p>
                                        </div>
                                    </div>
                                    <div className="col-lg-6">
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p className="m-0">Место работы: </p>
                                            <p className="fw-400">СГТУ Социально-экономический институт — кафедра "Философия, социология, культурология"</p>
                                        </div>
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


