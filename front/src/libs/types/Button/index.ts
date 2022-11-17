import { ReactNode } from "react";

export interface ButtonProps {
    children: ReactNode;
    variant?: string;
    onClick?: React.MouseEventHandler<HTMLButtonElement>
    type?: "button" | "submit" | "reset";
}