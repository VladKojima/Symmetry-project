import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import Select from "react-select";
import NavbarModerator from "./component/NavbarModerator";
import card_img from "../img/cool-card.png";
import { WithOutContext as ReactTags } from "react-tag-input";
import './registr.css';
import '../css/profile.css'; 

function VacanciesCreate() {
    const [title, setTitle] = useState([]);
    const [tr, setTr] = useState([]);
    const [usl, setUsl] = useState([]);
    const [tags, setTags] = useState([]);
    const handleAddition = (tag) => {
        setTags([...tags, tag]);
    };
    
    const handleDelete = (i) => {
        const newTags = tags.filter((tag, index) => index !== i);
        setTags(newTags);
    };

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
                        <div className="d-flex justify-content-between align-items-center">
                            <h4>Создать вакансию</h4>
                            <Button><NavLink to='/vacancis'>Сохранить</NavLink></Button>
                        </div>
                        <hr/>
                        <div className="mt-4">
                            <h5 className="mb-3">Заголовок:</h5>
                            <Form.Group>
                                <Form.Control type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                            </Form.Group>
                        </div>
                        <div className="mt-4">
                            <h5 className="mb-3">Теги: </h5>
                            <ReactTags tags={tags} handleAddition={handleAddition} handleDelete={handleDelete} placeholder="Введите тег" />
                        </div>
                        <div className="my-4">
                            <h5 className="mb-3">Требования: </h5>
                            <Form.Control as="textarea" rows={3} value={tr} onChange={(e) => setTr(e.target.value)} />
                        </div>
                        <div className="my-4">
                            <h5 className="mb-3">Условия: </h5>
                            <Form.Control as="textarea" rows={3} value={usl} onChange={(e) => setUsl(e.target.value)} />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default VacanciesCreate;


