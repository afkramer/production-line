import { Employee } from './Employee';
import { ProductionStep } from './ProductionStep';

export type Station = ProductionStep & {
  employees: Employee[];
};
