import React, { useState } from "react";
import { Button, Modal } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import Cookies from "js-cookie";
import axios from 'axios';
import "./registr.css";

function Login() {
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [loginError, setLoginError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const navigate = useNavigate();
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const myCookieValue = Cookies.get("myCookie");

  const handleClick = async () => {
    if (login.trim() === "") {
      setLoginError("Пожалуйста, введите логин.");
      return;
    } else {
      setLoginError("");
    }

    if (password.trim() === "") {
      setPasswordError("Пожалуйста, введите пароль.");
      return;
    } else {
      setPasswordError("");
    }

    axios.post('http://localhost:8080/api/auth/login', {
      login: login,
      password: password
    }, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then((response) => {
      if (response.status === 200) {
        return response.data;
      } else {
        throw new Error('Ошибка запроса');
      }
    })
    .then((data) => {
      Cookies.set("access_token", data.accessToken);
      if (data.role === "MODERATOR") {
        navigate('/moderator');
      } else if (data.role === "CORPORATION") {
        navigate('/company');
      } else {
        navigate('/student');
      }
    })
    .catch((error) => {
      console.error('Произошла ошибка:', error);
    });
  };

  return (
    <div className="content p-5 d-flex flex-column align-item-center justify-content-center">
      <div className="">
        <div>
          <h2 className="fs-30 fw-700 mb-5">Вход на сайт</h2>
          <label htmlFor="login" className="form-label">
            Логин
          </label>
          <input
            value={login}
            className="form-control mb-4"
            id="login"
            onChange={(e) => setLogin(e.target.value)}
          />
          {loginError && (
            <p className="error-message">{loginError}</p>
          )}
          <label htmlFor="password" className="form-label">
            Пароль
          </label>
          <input
            value={password}
            type="password"
            className="form-control"
            id="password"
            required
            onChange={(e) => setPassword(e.target.value)}
          />
          {passwordError && (
            <p className="error-message">{passwordError}</p>
          )}
          <Button className="mt-4 w-100 btn-primary" onClick={handleClick}>
            Вход
          </Button>
          <p className="mt-4">
            Нет аккаунта?
            <NavLink to={`/reg`}>Зарегистрироваться</NavLink>
          </p>
          <p className="mt-4">
            <a href="#" onClick={handleShow}>Забыли пароль?</a>
          </p>
        </div>
        <Modal show={show} onHide={handleClose} centered>
          <Modal.Header closeButton>
            <Modal.Title>Восстановление пароля</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <p>Уважаемый пользователь, для восстановления пароля обратитесь к системным администратором вашего университета или отправьте письмо на электронную почту <a href="mailto:sstu_office@sstu.ru?subject=Восстановление%20пароля">sstu_office@sstu.ru</a> с вложенными сканами/читаемыми снимками вашего студенческого билета. Для скорейшего рассмотрения заявки тему электронного письма укажите как "Восстановление пароля" и укажите аббревиатуру вашего ВУЗа</p>
          </Modal.Body>
          <Modal.Footer>
            <Button onClick={handleClose}>
              Закрыть
            </Button>
          </Modal.Footer>
      </Modal>
      </div>
    </div>
  );
}

export default Login;

