import { ReactNode } from "react";
import { DashBoardNavbar } from "../../components/NavBar/DashboardNav"; 

type props = { children: ReactNode; variant?: string, nome?: string };

export function DashBoardLayout({ children, variant, nome }: props) {
  return (
    <main className="page_wrapper bg-white">
      <DashBoardNavbar variant={variant} nome={nome} />
      <main className="default-main">{children}</main>
    </main>
  );
}
