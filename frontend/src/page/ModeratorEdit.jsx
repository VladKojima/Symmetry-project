import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarModerator from "./component/NavbarModerator";
import photo from "../img/photo_2023-10-15_01-12-32.jpg";
import './registr.css';
import '../css/profile.css'; 

function ModeratorEdit() {
    const [phone, setPhone] = useState('+79277896528');
    const [email, setEmail] = useState('q1@gmail.com');
    const [workPlace, setWorkPlace] = useState('СГТУ Социально-экономический институт — кафедра "Философия, социология, культурология"');
    const [fio, setFio] = useState('Реброва Мария Алексеевна');

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
                                    <img src={photo} alt="Default Profile" className="profile-photo img-fluid"/>
                                </div>
                            </div>
                            <div className="col-lg-9">
                                <div className="d-flex justify-content-between align-items-center">
                                    <Form.Group className="col-9">
                                        <Form.Label>ФИО:</Form.Label>
                                        <Form.Control type="text" value={fio} onChange={(e) => setFio(e.target.value)} />
                                    </Form.Group>
                                    <Button><NavLink to='/moderator'>Сохранить</NavLink></Button>
                                </div>
                                <hr/>
                                <div className="row g-4">
                                    <div className="col-lg-6">
                                        <Form.Group>
                                            <Form.Label>Телефон:</Form.Label>
                                            <Form.Control type="text" value={phone} onChange={(e) => setPhone(e.target.value)} />
                                        </Form.Group>
                                        <Form.Group>
                                            <Form.Label>Email:</Form.Label>
                                            <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                                        </Form.Group>
                                    </div>
                                    <div className="col-lg-6">
                                        <Form.Group>
                                            <Form.Label>Место работы:</Form.Label>
                                            <Form.Control type="text" value={workPlace} onChange={(e) => setWorkPlace(e.target.value)} />
                                        </Form.Group>
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
export default ModeratorEdit;
