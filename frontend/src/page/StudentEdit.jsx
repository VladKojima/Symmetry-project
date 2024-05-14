import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import NavbarStudent from "./component/NavbarStudent";
import { WithOutContext as ReactTags } from "react-tag-input";
import photo from "../img/photo_2023-10-15_01-12-32.jpg";
import './registr.css';
import '../css/profile.css'; 

function StudentEdit() {
    const [phone, setPhone] = useState('+79277896528');
    const [email, setEmail] = useState('q1@gmail.com');
    const [experience, setExperience] = useState('2 года');
    const [telegram, setTelegram] = useState('@tg');
    const [aboutMe, setAboutMe] = useState('');
    const [career, setCareer] = useState('');
    const [fio, setFio] = useState('Реюрова Мария Алексеевна');
    const [tags, setTags] = useState([]);
    const [skills, setSkills] = useState([]);  
    const [profSkills, setProfSkills] = useState([]);  
    
    const handleAddition = (tag) => {
        setTags([...tags, tag]);
    };
    
    const handleDelete = (i) => {
        const newTags = tags.filter((tag, index) => index !== i);
        setTags(newTags);
    };

    const handleAdditionSk = (tag) => {
        setSkills([...skills, tag]);
    };
    
    const handleDeleteSk = (i) => {
        const newTagsSk = skills.filter((tag, index) => index !== i);
        setSkills(newTagsSk);
    };

    const handleAdditionSkP = (tag) => {
        setProfSkills([...profSkills, tag]);
    };
    
    const handleDeleteSkP = (i) => {
        const newTagsSkP = profSkills.filter((tag, index) => index !== i);
        setProfSkills(newTagsSkP);
    };

    const [profilePhoto, setProfilePhoto] = useState(null);

    const handlePhotoChange = (event) => {
        const file = event.target.files[0];
        setProfilePhoto(file);
    };

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
                                    {profilePhoto ? (
                                        <img src={URL.createObjectURL(profilePhoto)} alt="Profile" className="profile-photo img-fluid"/>
                                    ) : (
                                        <img src={photo} alt="Default Profile" className="profile-photo img-fluid"/>
                                    )}
                                    <input type="file" onChange={handlePhotoChange} accept="image/*" />
                                </div>
                                <div className="mt-4">
                                    <h5 className="mb-3">Теги: </h5>
                                    <ReactTags tags={tags} handleAddition={handleAddition} handleDelete={handleDelete} placeholder="Введите тег" />
                                </div>
                            </div>
                            <div className="col-lg-9">
                                <div className="d-flex justify-content-between align-items-center">
                                    <Form.Group className="col-9">
                                        <Form.Label>ФИО:</Form.Label>
                                        <Form.Control type="text" value={fio} onChange={(e) => setFio(e.target.value)} />
                                    </Form.Group>
                                    <Button><NavLink to='/student'>Сохранить</NavLink></Button>
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
                                            <Form.Label>Опыт работы:</Form.Label>
                                            <Form.Control type="text" value={experience} onChange={(e) => setExperience(e.target.value)} />
                                        </Form.Group>
                                        <Form.Group>
                                            <Form.Label>Telegram:</Form.Label>
                                            <Form.Control type="text" value={telegram} onChange={(e) => setTelegram(e.target.value)} />
                                        </Form.Group>
                                    </div>
                                </div>
                                <div className="my-4">
                                    <h5 className="mb-3">Личные навыки: </h5>
                                    <ReactTags tags={skills} handleAddition={handleAdditionSk} handleDelete={handleDeleteSk} placeholder="Введите тег" />
                                </div>
                                <div className="mb-4">
                                    <h5 className="mb-3">Профессиональные навыки: </h5>
                                    <ReactTags tags={profSkills} handleAddition={handleAdditionSkP} handleDelete={handleDeleteSkP} placeholder="Введите тег" />
                                </div>
                                <div className="my-4">
                                    <h5 className="mb-3">Карьерные цели и интересы: </h5>
                                    <Form.Control as="textarea" rows={3} value={career} onChange={(e) => setCareer(e.target.value)} />
                                <div className="my-4">
                                    <h5 className="mb-3">О себе: </h5>
                                    <Form.Control as="textarea" rows={3} value={aboutMe} onChange={(e) => setAboutMe(e.target.value)} />
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
