import { FormEvent, useContext, useState } from "react";
import { DefaultLayout } from "../../layouts";
import { nanoid } from "nanoid";
import { AuthContext } from "../../libs/contexts/AuthContext";

export default function RegisterPage() {
  const { registerAccount } = useContext(AuthContext);

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [cpf, setCPF] = useState("");
  const [nome, setNome] = useState("");
  const [date, setDate] = useState("");
  const [phone, setPhone] = useState("");
  const [logradouro, setLogradouro] = useState("");
  const [cep, setCEP] = useState("");
  const [numero, setNumero] = useState("");
  const [complemento, setComplemento] = useState("");

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();

    const data = {
      id: nanoid(12),
      nome: nome,
      cpf: cpf,
      data_nascimento: date,
      email: email,
      senha: password,
      telefone: phone,
      logradouro: logradouro,
      cep: cep,
      numero_endereco: numero,
      complemento: complemento,
      saldo: 0,
      agencia: "1423",
      conta: "123134",
      avaliacoes: [],
      poupancas: [],
      pix: [],
      contatos: [],
      transferencia: [],
    };

    // JSON.stringify(data)

    await registerAccount(data);
  };

  return (
    <div className="index">
      <DefaultLayout variant="nofooter">
        <div className="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow-md sm:p-6 md:p-8 dark:bg-gray-800 dark:border-gray-700">
          <form
            onSubmit={(e) => handleSubmit(e)}
            className="grid grid-cols-2 gap-4 space-y-6"
            action="#"
          >
            <h5 className="text-xl font-medium text-gray-900 dark:text-white">
              Registre-se na plataforma
            </h5>
            <div> </div>
            <div>
              <label
                htmlFor="email"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Seu E-mail
              </label>
              <input
                type="email"
                name="email"
                id="email"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="name@gmail.com"
                required
              />
            </div>
            <div>
              <label
                htmlFor="password"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Sua senha
              </label>
              <input
                type="password"
                name="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="••••••••"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                required
              />
            </div>
            <div>
              <label
                htmlFor="cpf"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Seu CPF
              </label>
              <input
                type="text"
                name="cpf"
                id="cpf"
                value={cpf}
                onChange={(e) => setCPF(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="03842222122"
                required
              />
            </div>
            <div>
              <label
                htmlFor="name"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Seu nome
              </label>
              <input
                type="text"
                name="name"
                id="name"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="Rosangela Rodrigues"
                required
              />
            </div>
            <div>
              <label
                htmlFor="date"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Sua data de nascimento
              </label>
              <input
                type="text"
                name="date"
                value={date}
                onChange={(e) => setDate(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="10/24/22"
                required
              />
            </div>
            <div>
              <label
                htmlFor="phone"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Seu número celular
              </label>
              <input
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="(99) 9999-9999"
                required
              />
            </div>
            <div>
              <label
                htmlFor="logradouro"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Logradouro
              </label>
              <input
                type="text"
                name="logradouro"
                id="logradouro"
                value={logradouro}
                onChange={(e) => setLogradouro(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="Rua Clotilde Louro"
                required
              />
            </div>
            <div>
              <label
                htmlFor="cep"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                CEP
              </label>
              <input
                type="text"
                name="cep"
                id="cep"
                value={cep}
                onChange={(e) => setCEP(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="06900-00"
                required
              />
            </div>
            <div>
              <label
                htmlFor="numero"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Número
              </label>
              <input
                type="text"
                name="numero"
                id="numero"
                value={numero}
                onChange={(e) => setNumero(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="512"
                required
              />
            </div>
            <div>
              <label
                htmlFor="complemento"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Complemento
              </label>
              <input
                type="text"
                name="complemento"
                id="complemento"
                value={complemento}
                onChange={(e) => setComplemento(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="casa 1"
                required
              />
            </div>
            <button
              type="submit"
              className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
            >
              Registrar
            </button>
          </form>
        </div>
      </DefaultLayout>
    </div>
  );
}
