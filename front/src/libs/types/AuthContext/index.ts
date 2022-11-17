export type SignInCredentials = {
  cpf: string;
  senha: string;
};

export interface RegisterCredentials {
  id: string;
  nome: string;
  cpf: string;
  data_nascimento: string;
  email: string;
  senha: string;
  telefone: string;
  logradouro: string;
  cep: string;
  numero_endereco: string;
  complemento: string;
  saldo: number;
  agencia: string;
  conta: string;
  avaliacoes: any;
  poupancas: any;
  pix: any;
  contatos: any;
  transferencia: any;
}

export interface User extends RegisterCredentials   {
  cpf: string;
  senha: string;
};

export type AuthContextData = {
  signIn(credentialsLogin: SignInCredentials): Promise<void>;
  user?: User;
  registerAccount(credentialsRegister: RegisterCredentials): Promise<void>;
  isAuthenticated: boolean;
};
