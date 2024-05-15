import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarModerator from "./component/NavbarModerator";
import { WithOutContext as ReactTags } from "react-tag-input";
import photo from "../img/def-card.png";
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './registr.css';
import '../css/profile.css'; 

function StudentEdit() {
    const [number, setNumber] = useState('');
    const [email, setEmail] = useState('');
    const [namev, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [patronymic, setPatronymic] = useState('');
    const [bday, setBday] = useState('');
    const today = new Date();

    const createStudent = async () => {
        const date = new Date(bday);
const day = String(date.getDate()).padStart(2, '0');
const month = String(date.getMonth() + 1).padStart(2, '0'); 
const year = date.getFullYear();

const formattedDate = day + month + year;
console.log(formattedDate); 

        console.log(bday);
        const data = {
            number: number,
            email: email,
            name: namev,
            surname: surname,
            patronymic: patronymic,
            birthday: formattedDate
        };
    
        fetch('http://localhost:8080/api/student', {
            method: 'POST',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            window.location = "/students"
            console.log('Data sent successfully:', data);
        })
        .catch(error => {
            console.error('Error sending data:', error);
        });
    }
    


    return (
        <div className="container-fluid">
            <div className="row g-4">
                <div className="col-lg-3 px-0">
                    <NavbarModerator/>
                </div>
                <div className="col-lg-9">
                    <div className="container px-4 py-5">
                        <div className="d-flex justify-content-between align-items-center">
                            <h4>Создать студента</h4>
                            <Button onClick={createStudent}>Сохранить</Button>
                        </div>
                        <hr/>
                        <div className="row">
                            <div className="col-lg-3">
                                <div className="profile-photo-box">
                                    <img src={photo} alt="Default Profile" className="profile-photo img-fluid"/>
                                </div>
                            </div>
                            <div className="col-lg-9">
                                <div className="row g-4">
                                    <div className="col-lg-6">
                                        <div className="my-2">
                                            <label htmlFor="bday" className="form-label">Дата рождения</label>
                                            <div>
                                                <DatePicker id="bday" selected={bday} onChange={date => setBday(date)} required maxDate={today} dateFormat="dd.MM.yyyy" className="form-control mb-3" />
                                            </div>
                                        </div>
                                        <Form.Group className="my-2">
                                            <Form.Label>Email:</Form.Label>
                                            <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                                        </Form.Group>
                                        <Form.Group className="my-2">
                                            <Form.Label>Номер зачетки:</Form.Label>
                                            <Form.Control type="text" value={number} onChange={(e) => setNumber(e.target.value)} />
                                        </Form.Group>
                                    </div>
                                    <div className="col-lg-6">
                                        <Form.Group className="my-2">
                                            <Form.Label>Имя:</Form.Label>
                                            <Form.Control type="text" value={namev} onChange={(e) => setName(e.target.value)} />
                                        </Form.Group>
                                        <Form.Group className="my-2">
                                            <Form.Label>Фамилия:</Form.Label>
                                            <Form.Control type="text" value={surname} onChange={(e) => setSurname(e.target.value)} />
                                        </Form.Group>
                                        <Form.Group className="my-2">
                                            <Form.Label>Отчество:</Form.Label>
                                            <Form.Control type="text" value={patronymic} onChange={(e) => setPatronymic(e.target.value)} />
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
export default StudentEdit;
