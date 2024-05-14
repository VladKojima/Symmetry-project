// import { useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
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
                                <div className="mt-4">
                                    <h5 className="mb-3">Теги: </h5>
                                    <div className="d-flex gap-3 flex-wrap">
                                        <p className="m-0 badge">Аналитика</p>
                                        <p className="m-0 badge">Java</p>
                                        <p className="m-0 badge">React</p>
                                        <p className="m-0 badge">Docker</p>
                                        <p className="m-0 badge">ООП</p>
                                        <p className="m-0 badge">Веб-разработка</p>
                                        <p className="m-0 badge">Postgre</p>
                                        <p className="m-0 badge">Nginx</p>
                                        <p className="m-0 badge">Лидерство</p>
                                        <p className="m-0 badge">Адаптивность</p>
                                        <p className="m-0 badge">JS</p>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-9">
                                <div className="d-flex justify-content-between align-items-center">
                                    <p className="fs-24 m-0">Реброва Мария Алексеевна</p>
                                    <Button><NavLink to='/student/edit'>Редактировать</NavLink></Button>
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
                                            <p>Опыт работы:</p>
                                            <p className="fw-400">2 года</p>
                                        </div>
                                        <div className="d-flex gap-3 flex-wrap">
                                            <p>Telegram: </p>
                                            <p className="fw-400">@tg</p>
                                        </div>
                                    </div>
                                </div>
                                <div className="mb-4">
                                    <h5 className="mb-3">Личные навыки: </h5>
                                    <div className="d-flex gap-3 flex-wrap">
                                        <p className="m-0 badge">Коммуникация</p>
                                        <p className="m-0 badge">Лидерство</p>
                                        <p className="m-0 badge">Адаптивность</p>
                                        <p className="m-0 badge">Организация</p>
                                        <p className="m-0 badge">Творчество</p>
                                        <p className="m-0 badge">Аналитика</p>
                                        <p className="m-0 badge">Самомотивация</p>
                                        <p className="m-0 badge">Тимбилдинг</p>
                                        <p className="m-0 badge">Точность</p>
                                    </div>
                                </div>
                                <div className="mb-4">
                                    <h5 className="mb-3">Профессиональные навыки: </h5>
                                    <div className="d-flex gap-3 flex-wrap">
                                        <p className="m-0 badge">Java</p>
                                        <p className="m-0 badge">React</p>
                                        <p className="m-0 badge">Docker</p>
                                        <p className="m-0 badge">ООП</p>
                                        <p className="m-0 badge">Веб-разработка</p>
                                        <p className="m-0 badge">Postgre</p>
                                        <p className="m-0 badge">Nginx</p>
                                        <p className="m-0 badge">Mongo</p>
                                        <p className="m-0 badge">PHP</p>
                                        <p className="m-0 badge">JS</p>
                                    </div>
                                </div>
                                <div className="">
                                    <h5 className="mb-3">Карьерные цели и интересы: </h5>
                                    <p className="fw-400">Развитие профессиональных навыков в области программирования и информационных технологий. Получение новых знаний и опыта в сфере разработки программного обеспечения. Построение успешной карьеры в качестве программиста или разработчика. Участие в интересных проектах, которые помогут улучшить навыки и расширить кругозор. Рост в должности и повышение профессионального статуса.</p>
                                </div>
                                <div className="">
                                    <h5 className="mb-3">О себе: </h5>
                                    <p className="fw-400">Развитие профессиональных навыков в области программирования и информационных технологий. Получение новых знаний и опыта в сфере разработки программного обеспечения. Построение успешной карьеры в качестве программиста или разработчика. Участие в интересных проектах, которые помогут улучшить навыки и расширить кругозор. Рост в должности и повышение профессионального статуса.</p>
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


