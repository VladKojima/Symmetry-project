import { useState } from "react";
import { Button } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './registr.css'; 

function Registration() {
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [repPassword, setRepPassword] = useState('');
    const [email, setEmail] = useState('');
    const [tg, setTg] = useState('');
    const [step, setStep] = useState(1);
    const [error, setError] = useState('');
    const [name, setName] = useState('');
    const [lastname, setLastname] = useState('');
    const [surname, setSurname] = useState('');
    const [bday, setBday] = useState('');
    const [phone, setPhone] = useState('');
    const navigate = useNavigate();
    const [passwordMatch, setPasswordMatch] = useState(true);
    const [validEmail, setValidEmail] = useState(true);
    const [validPhone, setValidPhone] = useState(true);
    const [errorMessageTg, setErrorMessageTg] = useState('');
    const today = new Date();

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
        setPasswordMatch(e.target.value === repPassword);
    };
    
    const handleRepeatPasswordChange = (e) => {
        setRepPassword(e.target.value);
        setPasswordMatch(e.target.value === password);
    };

    const handleEmailChange = (e) => {
        const { value } = e.target;
        setEmail(value);
        const isValid = /\S+@\S+\.\S+/.test(value);
        setValidEmail(isValid);
    };

    const handlePhoneChange = (e) => {
        const { value } = e.target;
        setPhone(value);
        const isValid = /^\+(?:[0-9] ?){6,14}[0-9]$/.test(value);
        setValidPhone(isValid);
      };

      const handleTgChange = (e) => {
        const inputValue = e.target.value;
        setTg(inputValue);
        if (inputValue.includes('@')) {
          setErrorMessageTg('Ввод символа @ недопустим');
        } else {
          setErrorMessageTg('');
        }
      };

    const handleNextStep = () => {
        if (step === 1 && login !== '' && password !== '' && email !== '' && tg !== '' && password === repPassword && validEmail) {
            if (tg.includes('@')) {
                setErrorMessageTg('Ввод символа @ недопустим');
            } else {
                setStep(2);
                setError('');
            }
        } else if (step === 2 && name !== '' && lastname !== '' && surname !== '' && bday !== '' && phone !== '' && validPhone) {
            const user = { name, lastname, surname, login, password, email, tg, bday, phone };
            console.log(user);
            fetch("http://localhost:8080/user", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(user)
            }).then(() => {
                console.log("Новый пользователь");
                navigate("/");
            }).catch(error => {
                console.error("Ошибка при регистрации:", error);
            });
            console.log('Регистрация завершена!');
        } else {
          setError('Пожалуйста, заполните все поля.');
        }
      };
    
      const handlePrevStep = () => {
        if (step === 2) {
          setStep(1);
          setError('');
        }
      };

    return (
        <div className="content p-5">
            <div className="d-flex align-item-center justify-content-center">
                <div className="m-md-5">
                    <h2 className="fs-30 fw-700 mb-4">Регистрация</h2>
                    {step === 1 && (
                        <>
                            <label htmlFor="login" className="form-label">Логин</label>
                            <input value={login} className="form-control mb-3" id="login" onChange={e => setLogin(e.target.value)} />
                            <label htmlFor="password" className="form-label">Пароль</label>
                            <input value={password} type="password" className={`form-control mb-3 ${passwordMatch ? '' : 'red-form'}`} id="password" required onChange={handlePasswordChange} />
                            <label htmlFor="repPassword" className="form-label">Повторите пароль</label>
                            <input value={repPassword} type="password" className={`form-control mb-3 ${passwordMatch ? '' : 'red-form'}`} id="repPassword" required onChange={handleRepeatPasswordChange} />
                            {!passwordMatch && <p className="error-message">Пароли отличаются</p>}
                            <label htmlFor="email" className="form-label">Email</label>
                            <input value={email} type="text" className={`form-control mb-3 ${validEmail ? '' : 'red-form'}`} id="email" required onChange={handleEmailChange} />
                            {!validEmail && <p className="error-message">Email неверный</p>}
                            <label htmlFor="tg" className="form-label">Telegram</label>
                            <input value={tg} type="text" className="form-control mb-3" id="tg" required onChange={handleTgChange} />
                            {errorMessageTg && <p className="error-message">{errorMessageTg}</p>}
                        </>
                    )}
                    {step === 2 && (
                        <>
                            <label htmlFor="name" className="form-label">Имя</label>
                            <input value={name} className="form-control mb-3" id="name" required onChange={e => setName(e.target.value)} />
                            <label htmlFor="lastname" className="form-label">Фамилия</label>
                            <input value={lastname} className="form-control mb-3" id="lastname" required onChange={e => setLastname(e.target.value)} />
                            <label htmlFor="surname" className="form-label">Отчество</label>
                            <input value={surname} className="form-control mb-3" id="surname" required onChange={e => setSurname(e.target.value)} />
                            <label htmlFor="bday" className="form-label">Дата рождения</label>
                            <div>
                                <DatePicker id="bday" selected={bday} onChange={date => setBday(date)} required maxDate={today} dateFormat="dd/MM/yyyy" className="form-control mb-3" />
                            </div>
                            <label htmlFor="phone" className="form-label">Телефон</label>
                            <input value={phone} className={`form-control mb-3 ${validPhone ? '' : 'red-form'}`} required id="phone" onChange={handlePhoneChange} />
                            {!validPhone && <p className="error-message">Телефон неверный</p>}
                        </>
                    )}
                    {error && <div className="error-message">{error}</div>}
                    {step === 2 ? (
                        <Button className="mt-4 w-100" onClick={handleNextStep}>Зарегистрироваться</Button>
                    ) : (
                        <Button className="mt-4 w-100" onClick={handleNextStep}>Далее</Button>
                    )}
                    {step === 2 && (
                        <Button className="mt-4 w-100" onClick={handlePrevStep}>Назад</Button>
                    )}
                    <p className="mt-4 text-center">Есть аккаунт? <NavLink to={`/`}>Войти</NavLink></p>
                </div>
            </div>
        </div>
    )
}
export default Registration;


